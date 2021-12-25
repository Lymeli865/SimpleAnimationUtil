package cz.hydradev.AnimationUtil;

public class Animation {

	private double minValue, maxValue, value;
	private long speed;
	private boolean enbl = true, rev;
	private AnimationMode mode;
	
	private TimerUtil timer = new TimerUtil();
	
	public Animation(double minVal, double maxVal, long speed) {
		this.minValue = minVal;
		this.maxValue = maxVal;
		this.value = minVal;
		this.speed = speed;
		this.mode = AnimationMode.End;
	}
	
	public Animation(double minVal, double maxVal, long speed, AnimationMode mode) {
		this.minValue = minVal;
		this.maxValue = maxVal;
		this.value = minVal;
		this.speed = speed;
		this.mode = mode;
	}

	/**
	 * Updates animation.
	 */
	public void update() {
		if(!isPaused()) {
			switch(mode) {
			case Restart:
				if(timer.wait(speed, true)) {
					if(!(value >= maxValue) && !(value < minValue)) {
						value++;
					}else if(value >= maxValue) {
						value = minValue;
					}
				}
				break;
			case Reverse:
				if(timer.wait(speed, true)) {
					if(!rev) {
						if(!(value >= maxValue) && !(value < minValue)) {
							value++;
						}else if(value >= maxValue) {
							rev = true;
						}
					}else {
						if(value <= maxValue && !(value < minValue)) {
							value--;
						}else if(value <= minValue) {
							rev = false;
							if(value < minValue) {
								value = minValue;
							}
						}
					}
				}
				break;
			case End:
				if(timer.wait(speed, true)) {
					if(!(value >= maxValue) && !(value < minValue)) {
						value++;
					}else if(value >= maxValue) {
						value = maxValue;
					}
				}
				break;
			case Return:
				if(timer.wait(speed, true)) {
					if(!rev) {
						if(!(value >= maxValue) && !(value < minValue)) {
							value++;
						}else if(value >= maxValue) {
							rev = true;
						}
					}else {
						if(value <= maxValue && value > minValue) {
							value--;
						}else if(value == minValue) {
							//value = minValue;
						}
					}
				}
				break;
			default:
				break;
			}
		}
	}
	
	/**
	 * Returns animation mode.
	 */
	public AnimationMode getAnimationMode() {
		return mode;
	}

	/**
	 * Sets animation mode.
	 * @param mode - Animation mode
	 */
	public void setAnimationMode(AnimationMode mode) {
		this.mode = mode;
	}

	/**
	 * Resets animation.
	 */
	public void reset() {
		rev = false;
		value = minValue;
	}
	
	/**
	 * Pauses animation.
	 */
	public void pause() {
		enbl = false;
	}
	
	/**
	 * Resumes animation.
	 */
	public void resume() {
		enbl = true;
	}
	
	/**
	 * Returns true if animation is paused.
	 */
	public boolean isPaused() {
		return !enbl;
	}
	
	/**
	 * Returns minimal value.
	 */
	public double getMinValue() {
		return minValue;
	}

	/**
	 * Sets minimal value.
	 * @param minValue - minimal value
	 */
	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	/**
	 * Returns maximal value.
	 */
	public double getMaxValue() {
		return maxValue;
	}

	/**
	 * Sets maximal value.
	 * @param maxValue - maximal value
	 */
	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * Returns current value.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Sets current value.
	 * @param value - current value
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Returns current speed.
	 */
	public long getSpeed() {
		return speed;
	}

	/**
	 * Sets current speed.
	 * @param speed - speed in millis.
	 */
	public void setSpeed(long speed) {
		this.speed = speed;
	}
}