#!/bin/sh

YOCTO_IMG_PATH=build/tmp/deploy/images/raspberrypi3-64/

if [ ! -d "${YOCTO_IMG_PATH}" ]; then
    echo "Error: YOCTO_IMG_PATH '$YOCTO_IMG_PATH' does not exist."
    exit 1
fi

# Unmount any existing partitions of sd-card
sudo umount -f /dev/mmcblk0p1
sudo umount -f /dev/mmcblk0p2

# Setup the files
bmap_file=$(ls ${YOCTO_IMG_PATH}/tellsticklove-image*rootfs.wic.bmap | tail -n 1)
wic_file=$(ls ${YOCTO_IMG_PATH}/tellsticklove-image*rootfs.wic.bz2 | tail -n 1)

# Start flashing the images onto the sd-card
sudo bmaptool copy --bmap ${bmap_file} ${wic_file} /dev/mmcblk0