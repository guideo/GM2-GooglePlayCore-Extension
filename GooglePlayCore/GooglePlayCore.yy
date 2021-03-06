{
  "optionsFile": "options.json",
  "options": [],
  "exportToGame": true,
  "supportedTargets": 9223372036854775807,
  "extensionVersion": "1.0.0",
  "packageId": "com.redpillgames.googleplaycore",
  "productId": "",
  "author": "",
  "date": "2020-09-06T15:25:34.3729994+02:00",
  "license": "Free to use, also for commercial games.",
  "description": "",
  "helpfile": "",
  "iosProps": false,
  "tvosProps": false,
  "androidProps": true,
  "installdir": "",
  "files": [
    {"filename":"GooglePlayCore.ext","origname":"extensions\\GooglePlayCore.ext","init":"","final":"","kind":4,"uncompress":false,"functions":[
        {"externalName":"playcore_check_for_update","kind":11,"help":"playcore_check_for_update()","hidden":false,"returnType":2,"argCount":0,"args":[],"resourceVersion":"1.0","name":"playcore_check_for_update","tags":[],"resourceType":"GMExtensionFunction",},
        {"externalName":"playcore_show_update_prompt","kind":11,"help":"playcore_show_update_prompt()","hidden":false,"returnType":2,"argCount":0,"args":[],"resourceVersion":"1.0","name":"playcore_show_update_prompt","tags":[],"resourceType":"GMExtensionFunction",},
        {"externalName":"playcore_check_for_review","kind":11,"help":"playcore_check_for_review()","hidden":false,"returnType":2,"argCount":0,"args":[],"resourceVersion":"1.0","name":"playcore_check_for_review","tags":[],"resourceType":"GMExtensionFunction",},
        {"externalName":"playcore_show_review_prompt","kind":11,"help":"playcore_show_review_prompt()","hidden":false,"returnType":2,"argCount":0,"args":[],"resourceVersion":"1.0","name":"playcore_show_review_prompt","tags":[],"resourceType":"GMExtensionFunction",},
      ],"constants":[
        {"value":"7001","hidden":false,"resourceVersion":"1.0","name":"GooglePlayCore_AsyncEvent","tags":[],"resourceType":"GMExtensionConstant",},
      ],"ProxyFiles":[],"copyToTargets":8,"order":[
        {"name":"playcore_check_for_update","path":"extensions/GooglePlayCore/GooglePlayCore.yy",},
        {"name":"playcore_show_update_prompt","path":"extensions/GooglePlayCore/GooglePlayCore.yy",},
        {"name":"playcore_check_for_review","path":"extensions/GooglePlayCore/GooglePlayCore.yy",},
        {"name":"playcore_show_review_prompt","path":"extensions/GooglePlayCore/GooglePlayCore.yy",},
      ],"resourceVersion":"1.0","name":"","tags":[],"resourceType":"GMExtensionFile",},
  ],
  "classname": "",
  "tvosclassname": "",
  "tvosdelegatename": "",
  "iosdelegatename": "",
  "androidclassname": "GooglePlayCore",
  "sourcedir": "",
  "androidsourcedir": "",
  "macsourcedir": "",
  "maccompilerflags": "",
  "tvosmaccompilerflags": "",
  "maclinkerflags": "",
  "tvosmaclinkerflags": "",
  "iosplistinject": "",
  "tvosplistinject": "",
  "androidinject": "",
  "androidmanifestinject": "",
  "androidactivityinject": "",
  "gradleinject": "implementation 'com.google.android.play:core:1.8.0'",
  "iosSystemFrameworkEntries": [],
  "tvosSystemFrameworkEntries": [],
  "iosThirdPartyFrameworkEntries": [],
  "tvosThirdPartyFrameworkEntries": [],
  "IncludedResources": [],
  "androidPermissions": [],
  "copyToTargets": 8,
  "parent": {
    "name": "Extensions",
    "path": "folders/Extensions.yy",
  },
  "resourceVersion": "1.0",
  "name": "GooglePlayCore",
  "tags": [],
  "resourceType": "GMExtension",
}