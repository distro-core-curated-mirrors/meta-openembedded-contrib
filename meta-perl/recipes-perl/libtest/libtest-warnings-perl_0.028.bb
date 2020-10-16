# Copyright (C) 2020 Jens Rehsack <sno@netbsd.org>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "If you've ever tried to use Test::NoWarnings to confirm there are no \
warnings generated by your tests, combined with the convenience of \
\\"done_testing\\" to not have to declare a test count, you'll have discovered \
that these two features do not play well together, as the test count will \
be calculated *before* the warnings test is run, resulting in a TAP error. \
(See "examples/test_nowarnings.pl" in this distribution for a \
demonstration.)"

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"

HOMEPAGE=       "https://metacpan.org/release/Test-Warnings"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-1.0-only;md5=e9e36a9de734199567a4d769498f743d"

SRC_URI = "https://cpan.metacpan.org/authors/id/E/ET/ETHER/Test-Warnings-${PV}.tar.gz"

SRC_URI[md5sum] = "cd007342017fedfb02d6fde75602e473"
SRC_URI[sha256sum] = "26fda9f8d279e943d27e43a4a3a5cea8a6592cd36e7308695f8dc6602262c0e0"

S = "${WORKDIR}/Test-Warnings-${PV}"

inherit cpan ptest-perl

BBCLASSEXTEND = "native nativesdk"
