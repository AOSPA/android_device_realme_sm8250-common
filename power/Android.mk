LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := android.hardware.power@1.2-service.oppo_OP4A79
LOCAL_MODULE_TAGS  := optional

LOCAL_MODULE_RELATIVE_PATH := hw

LOCAL_CFLAGS += \
    -Wno-unused-parameter \
    -Wno-unused-variable

LOCAL_C_INCLUDES := \
    external/libxml2/include \
    external/icu/icu4c/source/common

LOCAL_HEADER_LIBRARIES += \
    libhardware_headers \
    libutils_headers

LOCAL_INIT_RC := android.hardware.power@1.2-service.oppo_OP4A79.rc

LOCAL_SRC_FILES := \
    hint-data.c \
    list.c \
    metadata-parser.c \
    power-common.c \
    Power.cpp \
    powerhintparser.c \
    service.cpp \
    utils.c

LOCAL_SHARED_LIBRARIES := \
    android.hardware.power@1.2 \
    libbase \
    libcutils \
    libdl \
    libhidlbase \
    libhidltransport \
    liblog \
    libutils \
    libxml2

LOCAL_VENDOR_MODULE := true

include $(BUILD_EXECUTABLE)
