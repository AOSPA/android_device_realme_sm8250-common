/*
 * Copyright (C) 2023 Paranoid Android
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#include <aidl/vendor/aospa/power/BnPowerFeature.h>
#include <android-base/file.h>
#include <android-base/strings.h>
#include <unordered_map>

#define GESTURE_ENABLE_PATH "/proc/touchpanel/double_tap_enable_indep"

using ::android::base::ReadFileToString;
using ::android::base::Trim;
using ::android::base::WriteStringToFile;

namespace aidl {
namespace vendor {
namespace aospa {
namespace power {

// based on values in touchpanel_common.h
static const std::unordered_map<Feature, int> GESTURE_MAP = {
    {Feature::DOUBLE_TAP, 1},
    {Feature::DRAW_V, 2},
    {Feature::DRAW_INVERSE_V, 3},
    {Feature::DRAW_O, 6},
    {Feature::DRAW_M, 12},
    {Feature::DRAW_W, 13},
    {Feature::DRAW_ARROW_LEFT, 5},
    {Feature::DRAW_ARROW_RIGHT, 4},
    {Feature::ONE_FINGER_SWIPE_UP, 11},
    {Feature::ONE_FINGER_SWIPE_RIGHT, 8},
    {Feature::ONE_FINGER_SWIPE_DOWN, 10},
    {Feature::ONE_FINGER_SWIPE_LEFT, 9},
    {Feature::TWO_FINGER_SWIPE, 7},
    {Feature::DRAW_S, 18},
    {Feature::SINGLE_TAP, 16},
};

bool setDeviceSpecificFeature(Feature feature, bool enabled) {
    int contents = 0;
    auto gesture = GESTURE_MAP.find(feature);

    if (gesture == GESTURE_MAP.end()) {
        // Unsupported gesture
        return false;
    }

    if (std::string tmp; ReadFileToString(GESTURE_ENABLE_PATH, &tmp)) {
        contents = std::stoi(Trim(tmp), nullptr, 16);
    }

    if (enabled) {
        contents |= (1 << gesture->second);
    } else {
        contents &= ~(1 << gesture->second);
    }

    return WriteStringToFile(std::to_string(contents), GESTURE_ENABLE_PATH, true);
}

}  // namespace power
}  // namespace aospa
}  // namespace vendor
}  // namespace aidl
