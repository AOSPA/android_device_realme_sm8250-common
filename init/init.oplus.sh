#! /vendor/bin/sh
#
# Copyright (C) 2022 The LineageOS Project
#
# SPDX-License-Identifier: Apache-2.0
#

prjname=`getprop ro.boot.prjname`

if [ "$prjname" = "19706" ] || [ "$prjname" = "19795" ] || [ "$prjname" = "21619" ] || [ "$prjname" = "2161A" ] || [ "$prjname" = "2169A" ] || [ "$prjname" = "2169B" ]; then
    setprop vendor.radio.multisim.config dsds
elif [ "$prjname" = "19705" ]; then
    setprop vendor.radio.multisim.config ssss
fi
