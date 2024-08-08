
LICENSE="CLOSED"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "telldusd.service"

SRC_URI += "file://telldusd.service"
FILES_${PN} += "${systemd_unitdir}/system/telldusd.service"

do_install_append() {
  install -d ${D}/${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/telldusd.service ${D}/${systemd_unitdir}/system
}
