Friends Sample App for iOS
=============================
This repository contains the [Friends sample app](http://docs.telerik.com/platform/backend-services/samples/friends/friends-sample) for iOS. The Friends app is a sample mobile app showcasing the integration of Telerik Platform services into an iOS appllication. To download the source code, just click on the "Download ZIP" button.

<span id="showcased-features-sdks" />
## Showcased features and SDKs

Here is a list of the features that are showcased in the Friends sample app:

- Cloud data access (Telerik Backend Services)
- Working with files (Telerik Backend Services)
- User registration and authentication (Telerik Backend Services)
- Authentication with external providers (Facebook, Google, etc.) (Telerik Backend Services)
- Basic app analytics (Telerik Analytics)
- Tracking custom events (Telerik Analytics)

To implement all the features listed above, the sample app utilizes the following Telerik products and SDKs:

- (Telerik Analytics) iOS SDK - used to work with Telerik Backend Services
- (Telerik Analytics) iOS SDK - used to work with Telerik Analytics.

## Requirements

The following is a list of requirements for the sample app:

- **Active Telerik Platform account**  
To use this sample app you must have an active Telerik Platform account. Depending on your license you may not be able to use all features of the app. For more information on what is included in the different editions, please check out the pricing page for the respective product. All features included in the sample app will work in the free trial period.

- **Compatible XCode version**  
XCode 5 or  or later must be installed on your Mac.


## Configuring the sample app
The Friends sample app comes fully functional, but to see it in action you must link it to your own Telerik Platform account.

What you need to set:

- **API key for Telerik Backend Services**  
This links the sample mobile app to a project in Telerik Backend Services. When you activate Telerik Backend Services a Friends sample project is created for you automatically. It has necessary structure defined and some data pre-filled. You must use its API key.  
To set the API key go to the EverliveSDKSample-Info.plist file and set the EverliveAPIKey row.
> If you happen to break the structure of the automatically generated Friends sample project, you can delete it and a fresh instance will be created again for you automatically. Alternatively, you could create a new project and choose to start from a Friends template, instead of starting from a blank project.

- [optional] **API key for Telerik Analytics**  
This step is optional, it links the sample mobile app to a Telerik Analytics project in your account. If you do not set this the sample will still work, but no analytics data will collected.

- [optional] **Facebook app ID**  
The sample app allows users to register using their Facebook account. We've pre-initialized the sample to use a Facebook app created by Telerik for the purpose. Please  replace the default setting in the EverliveSDKSample-Info.plist file.

- [optional] **Google**  
The sample app allows users to register using their Google account. Please  replace the default setting in the EverliveSDKSample-Info.plist file.

- [optional] **Windows Live**  
The sample app allows users to register using their Live account. Please  replace the default setting in the EverliveSDKSample-Info.plist file.

By default the Friends Sample is configured to use HTTP. In case you wish to switch to HTTPS please update the 'UseHTTPS' setting in the EverliveSDKSample-Info.plist file to "YES".

## Running the sample app
Once the app is configured as described in the previous section, you can run it either on a real device or in the simulator from within XCode.

> Make sure the emulator or the device you use have working Internet connection when running the sample. Internet connection is necessary in order to connect to the cloud.
