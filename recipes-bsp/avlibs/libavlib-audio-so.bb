SSUMMARY = "Amlogic audio video utils library"
PACKAGE_ARCH = "${MACHINE_ARCH}"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PV = "0"
PR = "r0"
SRCREV = ""
inherit lib_package


SRC_URI = "\
			file://libaac_helix.so \
			file://libac3.so \
			file://libadpcm.so \
			file://libamr.so \
			file://libape.so \
			file://libcook.so \
			file://libfaad_aml.so \
			file://libflac.so \
			file://libpcm_wfd.so \
			file://libmad_aml.so \
			file://libpcm.so \
			file://libraac.so \
			file://libdts.so \
			file://libdtshd.so \
"


S = "${WORKDIR}/"



do_install() {
		install -d ${D}${libdir}
    install -m 0755 ${WORKDIR}/libaac_helix.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libadpcm.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libamr.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libape.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libcook.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libfaad_aml.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libflac.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libpcm_wfd.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libmad_aml.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libpcm.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libraac.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libac3.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libdts.so ${D}/${libdir}
    install -m 0755 ${WORKDIR}/libdtshd.so ${D}/${libdir}
    
}

FILES_${PN} = "${includedir}/* ${libdir}/* "
FILES_${PN}-dev = "/usr/include/*"
FILES_${PN}-src = ""
