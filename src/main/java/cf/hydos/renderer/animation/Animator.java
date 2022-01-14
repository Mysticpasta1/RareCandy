package cf.hydos.renderer.animation;

import cf.hydos.renderer.animatedModel.AnimatedModel;
import cf.hydos.renderer.animatedModel.Joint;
import cf.hydos.renderer.utils.DisplayManager;
import org.joml.Matrix4f;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains all the functionality to apply an animationrenderer.animation to an
 * animated entity. An Animator instance is associated with just one
 * {@link AnimatedModel}. It also keeps track of the running time (in seconds)
 * of the current animationrenderer.animation, along with a reference to the currently playing
 * animationrenderer.animation for the corresponding entity.
 * <p>
 * An Animator instance needs to be updated every frame, in order for it to keep
 * updating the animationrenderer.animation pose of the associated entity. The currently playing
 * animationrenderer.animation can be changed at any time using the doAnimation() method. The
 * Animator will keep looping the current animationrenderer.animation until a new animationrenderer.animation is
 * chosen.
 * <p>
 * The Animator calculates the desired current animationrenderer.animation pose by interpolating
 * between the previous and next keyframes of the animationrenderer.animation (based on the
 * current animationrenderer.animation time). The Animator then updates the transforms all of the
 * joints each frame to match the current desired animationrenderer.animation pose.
 */
public class Animator {

    private final AnimatedModel entity;

    private Animation currentAnimation;
    private float animationTime = 0;

    /**
     * @param entity - the entity which will by animated by this animator.
     */
    public Animator(AnimatedModel entity) {
        this.entity = entity;
    }

    /**
     * Indicates that the entity should carry out the given animationrenderer.animation. Resets
     * the animationrenderer.animation time so that the new animationrenderer.animation starts from the beginning.
     *
     * @param animation - the new animationrenderer.animation to carry out.
     */
    public void doAnimation(Animation animation) {
        this.animationTime = 0;
        this.currentAnimation = animation;
    }

    /**
     * This method should be called each frame to update the animationrenderer.animation currently
     * being played. This increases the animationrenderer.animation time (and loops it back to
     * zero if necessary), finds the pose that the entity should be in at that
     * time of the animationrenderer.animation, and then applies that pose to all the model's
     * joints by setting the joint transforms.
     */
    public void update() {
        if (currentAnimation == null) {
            return;
        }
        increaseAnimationTime();
        Map<String, Matrix4f> currentPose = calculateCurrentAnimationPose();
        applyPoseToJoints(currentPose, entity.getRootJoint(), new Matrix4f());
    }

    /**
     * Increases the current animationrenderer.animation time which allows the animationrenderer.animation to
     * progress. If the current animationrenderer.animation has reached the end then the timer is
     * reset, causing the animationrenderer.animation to loop.
     */
    private void increaseAnimationTime() {
        animationTime += DisplayManager.getFrameTime();
        if (animationTime > currentAnimation.getLength()) {
            this.animationTime %= currentAnimation.getLength();
        }
    }

    /**
     * This method returns the current animationrenderer.animation pose of the entity. It returns
     * the desired local-space transforms for all the joints in a map, indexed
     * by the name of the joint that they correspond to.
     * <p>
     * The pose is calculated based on the previous and next keyframes in the
     * current animationrenderer.animation. Each keyframe provides the desired pose at a certain
     * time in the animationrenderer.animation, so the animated pose for the current time can be
     * calculated by interpolating between the previous and next keyframe.
     * <p>
     * This method first finds the preious and next keyframe, calculates how far
     * between the two the current animationrenderer.animation is, and then calculated the pose
     * for the current animationrenderer.animation time by interpolating between the transforms at
     * those keyframes.
     *
     * @return The current pose as a map of the desired local-space transforms
     * for all the joints. The transforms are indexed by the name ID of
     * the joint that they should be applied to.
     */
    private Map<String, Matrix4f> calculateCurrentAnimationPose() {
        KeyFrame[] frames = getPreviousAndNextFrames();
        float progression = calculateProgression(frames[0], frames[1]);
        return interpolatePoses(frames[0], frames[1], progression);
    }

    /**
     * This is the method where the animator calculates and sets those all-
     * important "joint transforms" that I talked about so much in the tutorial.
     * <p>
     * This method applies the current pose to a given joint, and all of its
     * descendants. It does this by getting the desired local-transform for the
     * current joint, before applying it to the joint. Before applying the
     * transformations it needs to be converted from local-space to model-space
     * (so that they are relative to the model's origin, rather than relative to
     * the parent joint). This can be done by multiplying the local-transform of
     * the joint with the model-space transform of the parent joint.
     * <p>
     * The same thing is then done to all the child joints.
     * <p>
     * Finally the inverse of the joint's bind transform is multiplied with the
     * model-space transform of the joint. This basically "subtracts" the
     * joint's original bind (no animationrenderer.animation applied) transform from the desired
     * pose transform. The result of this is then the transform required to move
     * the joint from its original model-space transform to it's desired
     * model-space posed transform. This is the transform that needs to be
     * loaded up to the vertex shader and used to transform the vertices into
     * the current pose.
     *
     * @param currentPose     - a map of the local-space transforms for all the joints for
     *                        the desired pose. The map is indexed by the name of the joint
     *                        which the transform corresponds to.
     * @param joint           - the current joint which the pose should be applied to.
     * @param parentTransform - the desired model-space transform of the parent joint for
     *                        the pose.
     */
    private void applyPoseToJoints(Map<String, Matrix4f> currentPose, Joint joint, Matrix4f parentTransform) {
        Matrix4f currentLocalTransform = currentPose.getOrDefault(joint.name, new Matrix4f());
        Matrix4f currentTransform = new Matrix4f(parentTransform).mul(new Matrix4f(currentLocalTransform));
        for (Joint childJoint : joint.children) {
            applyPoseToJoints(currentPose, childJoint, currentTransform);
        }
        currentTransform.mul(joint.getInverseBindTransform());
        joint.setAnimationTransform(currentTransform);
    }

    /**
     * Finds the previous keyframe in the animationrenderer.animation and the next keyframe in the
     * animationrenderer.animation, and returns them in an array of length 2. If there is no
     * previous frame (perhaps current animationrenderer.animation time is 0.5 and the first
     * keyframe is at time 1.5) then the first keyframe is used as both the
     * previous and next keyframe. The last keyframe is used for both next and
     * previous if there is no next keyframe.
     *
     * @return The previous and next keyframes, in an array which therefore will
     * always have a length of 2.
     */
    private KeyFrame[] getPreviousAndNextFrames() {
        KeyFrame[] allFrames = currentAnimation.getKeyFrames();
        KeyFrame previousFrame = allFrames[0];
        KeyFrame nextFrame = allFrames[0];
        for (int i = 1; i < allFrames.length; i++) {
            nextFrame = allFrames[i];
            if (nextFrame.getTimeStamp() > animationTime) {
                break;
            }
            previousFrame = allFrames[i];
        }
        return new KeyFrame[]{previousFrame, nextFrame};
    }

    /**
     * Calculates how far between the previous and next keyframe the current
     * animationrenderer.animation time is, and returns it as a value between 0 and 1.
     *
     * @param previousFrame - the previous keyframe in the animationrenderer.animation.
     * @param nextFrame     - the next keyframe in the animationrenderer.animation.
     * @return A number between 0 and 1 indicating how far between the two
     * keyframes the current animationrenderer.animation time is.
     */
    private float calculateProgression(KeyFrame previousFrame, KeyFrame nextFrame) {
        float totalTime = nextFrame.getTimeStamp() - previousFrame.getTimeStamp();
        float currentTime = animationTime - previousFrame.getTimeStamp();
        return currentTime / totalTime;
    }

    /**
     * Calculates all the local-space joint transforms for the desired current
     * pose by interpolating between the transforms at the previous and next
     * keyframes.
     *
     * @param previousFrame - the previous keyframe in the animationrenderer.animation.
     * @param nextFrame     - the next keyframe in the animationrenderer.animation.
     * @param progression   - a number between 0 and 1 indicating how far between the
     *                      previous and next keyframes the current animationrenderer.animation time is.
     * @return The local-space transforms for all the joints for the desired
     * current pose. They are returned in a map, indexed by the name of
     * the joint to which they should be applied.
     */
    private Map<String, Matrix4f> interpolatePoses(KeyFrame previousFrame, KeyFrame nextFrame, float progression) {
        Map<String, Matrix4f> currentPose = new HashMap<>();
        for (String jointName : previousFrame.getJointKeyFrames().keySet()) {
            JointTransform previousTransform = previousFrame.getJointKeyFrames().get(jointName);
            JointTransform nextTransform = nextFrame.getJointKeyFrames().get(jointName);
            JointTransform currentTransform = JointTransform.interpolate(previousTransform, nextTransform, progression);
            currentPose.put(jointName, currentTransform.getLocalTransform());
        }
        return currentPose;
    }

}
