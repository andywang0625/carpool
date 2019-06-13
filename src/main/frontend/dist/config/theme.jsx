"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const core_1 = require("@material-ui/core");
const palette_1 = require("./palette");
const typograhphy_1 = require("./typograhphy");
const spacingUnit = 4;
exports.theme = core_1.createMuiTheme({
    spacing: {
        unit: spacingUnit,
    },
    overrides: {
        MuiTableRow: {
            head: {
                height: 20,
            },
            root: {
                height: 32,
            },
            footer: {
                height: 32
            },
        },
        MuiTableCell: {
            root: {
                'borderColor': palette_1.palette.primary.light,
                '&:last-child': {
                    paddingRight: `${spacingUnit}px`,
                },
            },
            head: {
                fontWeight: 'bold',
                fontSize: 10,
                color: palette_1.palette.text.primary,
                borderColor: palette_1.palette.grey['500'],
                borderWidth: 1,
                padding: `${spacingUnit}px ${spacingUnit * 2}px`,
            },
            body: Object.assign({}, typograhphy_1.typography.body1, { padding: `${spacingUnit}px ${spacingUnit * 2}px` }),
        },
    },
    palette: palette_1.palette,
    typography: typograhphy_1.typography,
});
//# sourceMappingURL=theme.jsx.map