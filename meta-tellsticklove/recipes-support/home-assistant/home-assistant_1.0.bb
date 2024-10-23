SUMMARY = "Home Assistant systemd service"
DESCRIPTION = "Automatic start of Home Assistant if image has been created"
LICENSE = "CLOSED"

inherit systemd

# Specify dependencies if any
DEPENDS = "docker-compose"
RDEPENDS:${PN} = "docker-compose"

SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_SERVICE:${PN} = "home-assistant.service"

SRC_URI += "file://home-assistant.service \
            file://home-assistant.yml"

FILES:${PN} += "${systemd_unitdir}/system/home-assistant.service \
                ${sysconfdir}/docker/compose/home-assistant.yml"

# Define where to install the files
do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/home-assistant.service ${D}${systemd_unitdir}/system
    install -d ${D}${sysconfdir}/docker/compose
    install -m 0644 ${WORKDIR}/home-assistant.yml ${D}${sysconfdir}/docker/compose

    install -d ${D}${datadir}/home-assistant
}
