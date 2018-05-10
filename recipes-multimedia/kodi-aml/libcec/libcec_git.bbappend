PR_append = ".3"

# AML support included in new versions ?
#SRC_URI += "  file://libcec-00-amlogic-support.patch "

EXTRA_OECMAKE += '  -DHAVE_AMLOGIC_API=1 \
                '




