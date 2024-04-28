#! /vendor/bin/sh
#
# Copyright (C) 2022 The LineageOS Project
#
# SPDX-License-Identifier: Apache-2.0
#

prjname=`getprop ro.boot.prjname`

# Radio
if [ "$prjname" = "19705" ]; then
    setprop vendor.radio.multisim.config ssss
else
    setprop vendor.radio.multisim.config dsds
fi

# Wifi
persistbdf=`md5sum /mnt/vendor/persist/bdwlan.elf |cut -d" " -f1`
persistRegdb=`md5sum /odm/etc/wifi/regdb.bin |cut -d" " -f1`
vendorbdf=`md5sum /odm/etc/wifi/bdwlan.elf |cut -d" " -f1`
vendorRegdb=`md5sum /mnt/vendor/persist/regdb.bin |cut -d" " -f1`

if [ x"$vendorbdf" != x"$persistbdf" ]; then
    cp /odm/etc/wifi/bdwlan.elf /mnt/vendor/persist/bdwlan.elf
    sync
    echo "bdf check"
fi

if [ x"$vendorRegdb" != x"$persistRegdb" ]; then
    cp /odm/etc/wifi/regdb.bin /mnt/vendor/persist/regdb.bin
    sync
    echo "regdb check"
fi

chmod 666 /mnt/vendor/persist/bdwlan.elf
chmod 666 /mnt/vendor/persist/regdb.bin
chown system:wifi /mnt/vendor/persist/bdwlan.elf
chown system:wifi /mnt/vendor/persist/regdb.bin
