LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional
LOCAL_MODULE := UninstallApplication
LOCAL_SRC_FILES := $(LOCAL_MODULE).apk
LOCAL_MODULE_CLASS := APPS
LOCAL_VENDOR_MODULE := true
LOCAL_CERTIFICATE := presigned
include $(BUILD_PREBUILT)
