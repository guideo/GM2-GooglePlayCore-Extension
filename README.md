# GM2-GooglePlayCore-Extension

## This is an extension intended to be used with GameMaker 2

Allows you to check against Play Store, if there is an update available for your game.

If there is, you can then launch an intent to start the update (only doing IMMEDIATE update at the moment, but you can put it behind your own "popup" before starting it). The intent itself follows Google's Design.
There are currently only two methods: **playcore_check_for_update()** and **playcore_show_update_prompt()**.
You MUST run **playcore_check_for_update()** before running **playcore_show_update_prompt()**.
You can also listen to the async response of **playcore_check_for_update()**, doing (add an Async Social method):

    var _id = async_load[? "id"];
    if _id == GooglePlayCore_AsyncEvent {
        var ident = async_load[? "type"];
        switch (ident) {
            case "update_available":
            show_debug_message("yoyo async worked for my extension");
            break;
        }
    }

This was developed based on https://developer.android.com/guide/playcore/in-app-updates

I would really appreciate if eventually YoYo managed to implement this as their own package, giving more support and also including the features that I have left out (as you can check on the class *GooglePlayCore.java*)
