/*
 * Copyright (C) 2022 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

#include <android-base/logging.h>
#include <android-base/properties.h>

#define _REALLY_INCLUDE_SYS__SYSTEM_PROPERTIES_H_
#include <sys/_system_properties.h>

using android::base::GetProperty;

/*
 * SetProperty does not allow updating read only properties and as a result
 * does not work for our use case. Write "OverrideProperty" to do practically
 * the same thing as "SetProperty" without this restriction.
 */
void OverrideProperty(const char* name, const char* value) {
    size_t valuelen = strlen(value);

    prop_info* pi = (prop_info*)__system_property_find(name);
    if (pi != nullptr) {
        __system_property_update(pi, value, valuelen);
    } else {
        __system_property_add(name, strlen(name), value, valuelen);
    }
}

/*
 * Only for read-only properties. Properties that can be wrote to more
 * than once should be set in a typical init script (e.g. init.oplus.hw.rc)
 * after the original property has been set.
 */
void vendor_load_properties() {
    auto prj_version = std::stoi(GetProperty("ro.boot.prj_version", "0"));

    switch (prj_version) {
        case 19705: // bladerunner Global 1
            OverrideProperty("ro.product.product.device", "RMX2075L1");
            OverrideProperty("ro.product.product.model", "RMX2075");
            break;
        case 19795: // bladerunner CN
            OverrideProperty("ro.product.product.device", "RMX2071L1");
            OverrideProperty("ro.product.product.model", "RMX2071");
            break;
        case 21619: // bitra CN
            OverrideProperty("ro.product.product.device", "RE5473");
            break;
        default:
            LOG(ERROR) << "Unexpected project version: " << prj_version;
    }
}
