package com.loquesea.animaciones;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import com.loquesea.animaciones.SLConfig.Tile;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

public class SLTransition {
	private final SLPanel panel;
	private final TweenManager tweenManager;
	private final List<SLKeyframe> keyframes = new ArrayList<SLKeyframe>();
	private int currentKeyframe;
	private Timeline timeline;

	public SLTransition(SLPanel panel, TweenManager tweenManager) {
		this.panel = panel;
		this.tweenManager = tweenManager;
	}


	
	public SLTransition push(SLKeyframe kf) {
		keyframes.add(kf);
		return this;
	}


	public boolean play() {
		if (!panel.isTransitionPlaying) {
			currentKeyframe = 0;
			play(keyframes.get(0), new SLKeyframe(panel.currentCfg, 0));
			panel.isTransitionPlaying = true;
			return true;
		}
		return false;
	}


	private void play(SLKeyframe kf, SLKeyframe previousKf) {
		panel.currentCfg = kf.getCfg();
		kf.initialize(previousKf);
		tween(kf);
	}

	private void tween(final SLKeyframe kf) {
		if (timeline != null) timeline.kill();

		timeline = Timeline.createParallel();

		for (Component c : kf.getCmps()) {
			Tile t = kf.getTarget(c);

			int dx = c.getX() - t.x;
			int dy = c.getY() - t.y;
			int dw = c.getWidth() - t.w;
			int dh = c.getHeight() - t.h;
			boolean animXY = (dx != 0) || (dy != 0);
			boolean animWH = (dw != 0) || (dh != 0);
			float duration = kf.getDuration();

			if (animXY && animWH) {
				timeline.push(Tween.to(c, SLAnimator.ComponentAccessor.XYWH, duration)
					.target(t.x, t.y, t.w, t.h)
					.delay(kf.getDelay(c))
				);
			} else if (animXY) {
				timeline.push(Tween.to(c, SLAnimator.ComponentAccessor.XY, duration)
					.target(t.x, t.y)
					.delay(kf.getDelay(c))
				);
			} else if (animWH) {
				timeline.push(Tween.to(c, SLAnimator.ComponentAccessor.WH, duration)
					.target(t.w, t.h)
					.delay(kf.getDelay(c))
				);
			}
		}

		timeline.setCallback(new TweenCallback() {
			@Override public void onEvent(int type, BaseTween<?> source) {
				for (Component c : kf.getCmpsToAddAfterTransition()) {
					panel.add(c, new Integer(1));
				}

				for (Component c : kf.getCmpsToRemoveAfterTransition()) {
					panel.remove(c);
				}

				if (kf.getCallback() != null) kf.getCallback().done();

				if (currentKeyframe < keyframes.size()-1) {
					currentKeyframe++;
					play(keyframes.get(currentKeyframe), keyframes.get(currentKeyframe-1));
				} else {
					panel.isTransitionPlaying = false;
				}
			}
		});

		timeline.start(tweenManager);
	}
}
