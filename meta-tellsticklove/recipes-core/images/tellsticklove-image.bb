# Base this image on rpi test image
include recipes-core/images/rpi-test-image.bb

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL += " dropbear libconfuse libftdi ftdi-modprobe telldus-core telldus-daemon telldus-core-mqtt docker-ce"
IMAGE_FEATURES += " ssh-server-dropbear"

# 32 GB SD card - add 25 GB to the root filesystem size
# 25 GB => 25 * 1024 * 1024
IMAGE_ROOTFS_EXTRA_SPACE = "20971520"
