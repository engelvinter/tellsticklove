DESCRIPTION = "Custom USB rule to load FTDI and USB Serial drivers"
LICENSE = "CLOSED"

SRC_URI = "file://99-usb-ftdi.rules"

do_install() {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/99-usb-ftdi.rules ${D}${sysconfdir}/udev/rules.d/
}

FILES_${PN} += "${sysconfdir}/udev/rules.d/99-usb-ftdi.rules"
