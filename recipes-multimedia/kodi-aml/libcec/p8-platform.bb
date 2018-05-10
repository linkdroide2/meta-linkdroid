SUMMARY = "Platform support library used by libCEC and binary add-ons for Kodi"
HOMEPAGE = "http://libcec.pulse-eight.com/"

require conf/license/license-gplv2.inc

DEPENDS = ""

PV = "1aml"

SRC_URI[md5sum] = "8140d9e2666e6765890ad2fa676d345c"
SRC_URI[sha256sum] = "255221e38c6e0a3a0791a26a9cabb1bad725f05800230e93bfbf0b60d1072987"

SRC_URI = "https://github.com/Pulse-Eight/platform/archive/38343e0.tar.gz\
           file://p8-platform-01-revert-cc-badness.patch \ 
"

S = "${WORKDIR}/platform-38343e0acd6a636ac46139aa666aee4a8d1f13db"

inherit cmake  pkgconfig

EXTRA_OECMAKE = '  -DHAVE_AMLOGIC_API=1 \
                '


# cec-client and xbmc need the .so present to work :(
FILES_${PN} += "${libdir}/*.so"
INSANE_SKIP_${PN} = "dev-so"

# Adapter shows up as a CDC-ACM device
RRECOMMENDS_${PN} = "kernel-module-cdc-acm"

