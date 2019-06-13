"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const createTypography_1 = require("@material-ui/core/styles/createTypography");
const palette_1 = require("./palette");
exports.typography = createTypography_1.default(palette_1.palette, {
    fontFamily: 'Helvetica',
    useNextVariants: true,
    h1: {
        fontSize: 22,
        fontWeight: 600,
    },
    h2: {
        fontSize: 20,
        fontWeight: 'bold',
    },
    h3: {
        fontSize: 12,
        fontWeight: 'bold',
    },
    body1: {
        fontSize: 10,
    },
    body2: {
        fontSize: 8,
    },
    caption: {
        fontSize: 8,
    },
});
//# sourceMappingURL=typograhphy.jsx.map