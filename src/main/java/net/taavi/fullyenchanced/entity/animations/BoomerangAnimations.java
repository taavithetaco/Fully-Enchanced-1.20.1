package net.taavi.fullyenchanced.entity.animations;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class BoomerangAnimations {




    public static final Animation SPINNING = Animation.Builder.create(1f).looping()
            .addBoneAnimation("boomerang_entity",
                    new Transformation(Transformation.Targets.ROTATE,
                            new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
                                    Transformation.Interpolations.LINEAR),
                            new Keyframe(1f, AnimationHelper.createRotationalVector(0f, 720f, 0f),
                                    Transformation.Interpolations.LINEAR))).build();
}
