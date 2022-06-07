#
# Copyright (C) 2020 The LineageOS Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Inherit from those products. Most specific first.
$(call inherit-product, $(SRC_TARGET_DIR)/product/core_64_bit.mk)
$(call inherit-product, $(SRC_TARGET_DIR)/product/full_base_telephony.mk)

# Inherit some common ArrowOS stuff
$(call inherit-product, vendor/arrow/config/common.mk)
ARROW_GAPPS := true
TARGET_BOOT_ANIMATION_RES := 1080
TARGET_INCLUDE_PIXEL_CHARGER := true

# Inherit from device
$(call inherit-product, $(LOCAL_PATH)/device.mk)

# Device identifier. This must come after all inclusions.
PRODUCT_NAME := arrow_bitra
PRODUCT_DEVICE := bitra
PRODUCT_BRAND := realme
PRODUCT_MODEL := RMX3370
PRODUCT_MANUFACTURER := realme

PRODUCT_GMS_CLIENTID_BASE := android-oppo

PRODUCT_BUILD_PROP_OVERRIDES += \
    TARGET_DEVICE=RE879AL1 \
    TARGET_PRODUCT=RMX3370 \
    PRIVATE_BUILD_DESC="RMX3370-user 12 SKQ1.210216.001 R.202203191836 release-keys"

BUILD_FINGERPRINT := google/redfin/redfin:12/SQ3A.220605.009.A1/8643238:user/release-keys
