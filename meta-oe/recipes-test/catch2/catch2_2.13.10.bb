DESCRIPTION = "A modern, C++-native, header-only, test framework for unit-tests, \
TDD and BDD - using C++11, C++14, C++17 and later."
HOMEPAGE = "https://github.com/catchorg/Catch2"
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e4224ccaecb14d942c71d31bef20d78c"

SRC_URI = "git://github.com/catchorg/Catch2.git;branch=v2.x;protocol=https"
SRCREV = "182c910b4b63ff587a3440e08f84f70497e49a81"

S = "${WORKDIR}/git"

inherit cmake python3native

do_install:append() {
    rm ${D}${datadir}/Catch2/lldbinit
    rm ${D}${datadir}/Catch2/gdbinit
    rmdir ${D}${datadir}/Catch2/
}
# Header-only library
RDEPENDS:${PN}-dev = ""
RRECOMMENDS:${PN}-dbg = "${PN}-dev (= ${EXTENDPKGV})"

# This one is reproducible only on 32bit arm MACHINEs (didn't see it with qemux86 or qemux86-64 builds)
# http://errors.yoctoproject.org/Errors/Details/766975/
# lib32-catch2/2.13.10/git/projects/SelfTest/UsageTests/ToStringGeneral.tests.cpp:122:32: error: value computed is not used [-Werror=unused-value]
CXXFLAGS += "-Wno-error=unused-value"
