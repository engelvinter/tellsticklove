DESCRIPTION = "Custom USB rule to load FTDI and USB Serial drivers"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835b92f4edbff56125ed3f99e0b5811"

SRC_URI = "file://99-usb-ftdi.rules"

do_install() {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/99-usb-ftdi.rules ${D}${sysconfdir}/udev/rules.d/
}

FILES_${PN} += "${sysconfdir}/udev/rules.d/99-usb-ftdi.rules"
