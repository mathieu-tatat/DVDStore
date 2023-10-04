/** @type {import('tailwindcss').Config} */
const defaultTheme = require('tailwindcss/defaultTheme')

module.exports = {
  content: ["./src/**/*.{html,ts}"],
  theme: {
    FontFamily: {
      'sans': ['Proxima Nova', ...defaultTheme.fontFamily.sans],
    },
    margin: {
      '5px': '5px',
      100: '25rem',
      104: '26rem',
      108: '27rem',
      112: '28rem',
      116: '29rem',
      120: '30rem',
      124: '31rem',
      128: '32rem',
      
    },
    height:{
      15.5:'60px',
      100: '25rem',
      104: '26rem',
      108: '27rem',
      112: '28rem',
      116: '29rem',
      120: '30rem',
      124: '31rem',
      128: '32rem',
      136: '34rem',
      144: '36rem',
      160: '40rem',
      176: '44rem',
      192: '48rem',
      208: '52rem',
      224: '56rem',
    },

    colors: {
      range:{
      400:'#E78B26',
      100:"#F2A047"},

      basic:{
        DEFAULT: '#303338',
        400:'#303338'
      },

      fumee:'#F4EDD8',

      granny: {
        DEFAULT: '#86A5A5',
        50: '#D8E2E2',
        100: '#CCD9D9',
        200: '#B5C8C8',
        300: '#9DB6B6',
        400: '#86A5A5',
        500: '#688B8B',
        600: '#506B6B',
        700: '#384B4B',
        800: '#202B2B',
        900: '#080B0B',
        950: '#000000',
      },
    },
  },
  plugins: [],
}

