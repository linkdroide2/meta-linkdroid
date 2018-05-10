SUMMARY = "Amlogic audio decoders library"
PACKAGE_ARCH = "${MACHINE_ARCH}"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r2a"

#libaac-helix libadpcm libamr libape libcook libpcm libmad-aml liblpcm libraac libfaad-aml libflac-aml 

DEPENDS = "libamavutils alsa-lib rtmpdump "
RDEPENDS_${PN} = "ffmpeg libamavutils"

### for DTS encoder: don't check for stripped & text relocations
INSANE_SKIP_${PN} = "already-stripped textrel"

inherit lib_package


SRC_URI = "file://avplayer/LibAudio/amadec/include/* \
           file://libamadec.pc \
	   file://libamadec.so \
"

S = "${WORKDIR}/avplayer/LibAudio/amadec"


### NOTE: we are installing closed src DTS encoder as well for transcoding
do_install() {
    install -d ${D}${libdir}/pkgconfig
    install -d ${D}${includedir}/amlogic/amadec
    install -d ${D}${includedir}/amlogic/amadec/amports
    install -d ${D}${includedir}/amlogic/amadec/system
#    install -d ${D}${base_libdir}/firmware
    install -d ${D}${libdir}
    install -m 0755 ${S}/include/*.h ${D}${includedir}/amlogic/amadec
    install -m 0755 ${WORKDIR}/libamadec.so ${D}/${libdir}
    install -m 0644 ${WORKDIR}/libamadec.pc ${D}${libdir}/pkgconfig/
}

FILES_${PN} = "${libdir}/* ${base_libdir}/firmware"
FILES_${PN}-dev = "${includedir}/*"
