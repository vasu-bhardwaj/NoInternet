# NoInternet Dialog
 An Android library that allows you to easily check android applications Network Connectivity.Shows dialog fragment when connection is lost and the dialog fragment is dismissed when connection is back.
 
 You may use it in your Android apps provided that you cite this project and include the license in your app. Thanks!



![Alt Text](https://github.com/vasu-bhardwaj/OnBoardingEasy/blob/master/preview/ImgPreview.gif)



## Usage
### Step 1:
#### Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```gradle

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}	
```	

 ### Step 2:
#### Add the dependency

```gradle

	dependencies {
	        implementation 'com.github.vasu-bhardwaj:NoInternet:V1.3'
	}
```
	
 ### Step 3:
#### Create a new Activity 

 ### Step 4:
#### Create a Instance of FragmentManager and NoNet.
After creating instance of fragmentManager and NoNet.

get supported fragmentManager in onCreate(), method

####         fm = getSupportFragmentManager();

and init the NoNet dialog in onCreate method 
####  mNoNet = new NoNet();
 ####  mNoNet.initNoNet(this, fm);

```java
public class MainActivity extends AppCompatActivity {
private FragmentManager fm = null;
private  NoNet mNoNet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        mNoNet = new NoNet();
        mNoNet.initNoNet(this, fm);
    }
```
 ### Step 5:
#### Now you just need to Register and unRegister NoNet dialog.


``` java
 @Override
    protected void onResume() {
        mNoNet.RegisterNoNet();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mNoNet.unRegisterNoNet();
        super.onPause();
    }
```
	    
 ### Note :-> Don't forget to unRegister the NoNet Dialog.
 
 ## Use the above steps to include the NoNet dialog in any Activity.

## Getting Help

To report a specific problem or feature request,, please let by opening a new Issue.(https://github.com/vasu-bhardwaj/NoInternet/issues/new)

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
