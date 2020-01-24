# Mobile Application "What could I cook?"
## 1. Introduction
### Part A - image classification
As of now it is safe to say we will going to use TensorFlow Lite Image classification.
[**Here**](https://github.com/tensorflow/examples/tree/master/lite/examples/image_classification/android) is good starting point explaining how to set up android example. This example set you classify images live from camera feed. This is not axacly what we are looking for but can make for a good base to build upon.
Download project: 
```
git clone https://github.com/tensorflow/examples
```

Open the TensorFlow source code in Android Studio. To do this, open Android
Studio and select `Open an existing project`, setting the folder to
`examples/lite/examples/image_classification/android`

* For details of the model used, visit [Image classification](https://www.tensorflow.org/lite/models/image_classification/overview).

* Develop your own Android app for image recognition with tensorflow in 20 minutes [link](https://medium.com/@sa_m_u/develop-your-own-android-image-recognition-app-with-tensorflow-in-20-minutes)

### Part B - recipe library/API</br>
[Here](https://github.com/ddsky/spoonacular-api-clients/tree/7bb2b9668369b3fd64300a8f078636da7dad9d6c/android) is a source of how to implement **spoonacular** API Client.
You can read more about the Spoonacular API [here.](https://github.com/dechantoine/androidproject/blob/master/spoonacular-api-slides.pdf)
<br>
API is not open source but they have "free plan". It is limited to 150 calls per day which in our case is sufficient enough for testing and presentation, in my opinion.
<br>
***Alternative***
<br>
After todays (15/10/2019) lab session meeting we have decided to go on and use simple database (like, MySQL) in order to show the concept. Configuring spoonacular API proved to be difficult task for beginners in Android development.

## 2. Resources
***Android Studio***
<br>
* How to use software Version Control (Github) - [Download .rar](https://drive.google.com/file/d/10Kzzxg9hnqzR5almRMRjjshyjvdeysXA/view?usp=sharing)


## 3. Wireframe - first iteration
<br>
<img src="https://github.com/dechantoine/what_could_I_cook_app/blob/master/wireframe%20giff.gif" alt="drawing" width="400"/>

## 4. Must have functionality

* Image
* Button and Text. Insert simpleText (inputType). Include change of colour, font, and size.
* Use logic like *switch*
* Add GPS
* Adding multiple activities
* Add video or audio file at the beggining of the app launch

