package com.example.android.jokeprovider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JokeProvider {

  public String getJoke() {
    List<String> jokes = Arrays.asList(
        "What do you call an ant who fights crime? A vigilanty!",
        "What is fast, loud and crunchy? A rocket chip!",
        "Why did the teddy bear say no to dessert? Because she was stuffed.",
        "What has ears but cannot hear? A cornfield",
        "What did the left eye say to the right eye? Between us, something smells!",
        "Why did the police play baseball? He wanted to get a catch!",
        "Why did the student eat his homework? Because the teacher told him it was a piece of cake!",
        "When you look for something, why is it always in the last place you look? Because when " +
        "you find it, you stop looking",
        "What is brown, hairy and wears sunglasses? A coconut on vacation",
        "What did the Dalmatian say after lunch? That hit the spot!"
    );

    int maxNumber = jokes.size() - 1;
    int jokeNumber = (int) Math.floor(Math.random() * maxNumber);

    return jokes.get(jokeNumber);
  }
}