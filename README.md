# SimpleAnimationUtil
Simple animation util for java

How to use:
```java
//Initializates variable
//1 is minimal value, 150 is maximal value, 50 is speed(in ms) and AnimationMode.Return is animation mode
Animation animation = new Animation(1, 150, 50, AnimationMode.End);

//Sets minimal value
animation.setMinValue(minValue);

//Sets maximal value
animation.setMaxValue(maxValue);

//Sets speed
animation.setSpeed(speed);

//Sets animation mode
//Animation modes: 
//  End - Makes animation from min value to max value and stops
//  Return - Makes animation from min value to max value and returns to min value
//  Reverse - Makes animation from min value to max value, then returns to min value and again makes animation from min value to max value, it repeats infinitely
//  Restart - Makes animation from min value to max value and it repeats infinitely
animation.setAnimationMode(mode);

//Updates animation
animation.update();

//Pauses animation
animation.pause();

//Resumes animation
animation.resume();

//Resets animation
animation.reset();

//How to use value in rectangle
drawRect(animation.getValue(), 10, animation.getValue() + 10, 20, -1);
```
