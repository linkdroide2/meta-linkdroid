SUMMARY = "Platform support library used by libCEC and binary add-ons for Kodi"
HOMEPAGE = "http://libcec.pulse-eight.com/"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://src/os.h;md5=752555fa94e82005d45fd201fee5bd33"

PV = "2.2.0b"

SRC_URI = "git://github.com/Pulse-Eight/platform.git"
#SRCREV = "d7bceb64541cb046421cbcd4c98d91e9bf24822f"
SRCREV = "a822e196cb57d8545dccca6cc22fda0f83c34321"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE += "-DCMAKE_INSTALL_LIBDIR=${libdir} -DCMAKE_INSTALL_LIBDIR_NOARCH=${libdir}  -DHAVE_AMLOGIC_API=1 "

FILES_${PN}-dev += "${libdir}/p8-platform"
