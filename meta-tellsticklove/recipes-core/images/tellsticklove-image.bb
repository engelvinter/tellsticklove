# Base this image on rpi test image
include recipes-core/images/rpi-test-image.bb

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL += " sudo \
                   dropbear \
                   libconfuse \
                   libftdi \
                   ftdi-modprobe \
                   telldus-core \
                   telldus-daemon \
                   telldus-core-mqtt \
                   docker-compose \
                   mosquitto \
                   mosquitto-clients \
                   home-assistant"

IMAGE_FEATURES += " ssh-server-dropbear"

# Inherit the extrausers class to manage users
inherit extrausers

# Set the encrypted password for the root user and telldus user
EXTRA_USERS_PARAMS = "useradd -m -G sudo telldus; \
                      usermod -p '\$1\$wj5pSyig\$0SeDT0ZDnPgUV5PIh8O1x0' telldus; \
                      usermod -p '\$1\$wj5pSyig\$0SeDT0ZDnPgUV5PIh8O1x0' root;"

# 32 GB SD card - add 25 GB to the root filesystem size
# 25 GB => 25 * 1024 * 1024
IMAGE_ROOTFS_EXTRA_SPACE = "20971520"
