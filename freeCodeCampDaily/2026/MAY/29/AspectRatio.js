// 29May2026
// Given two strings for different image dimensions, return the aspect ratio of the image with a greater width-to-height ratio.

// The given strings will be in the format "WxH", for example, "1920x1080".
// The aspect ratio is the ratio of width to height, reduced to the lowest whole numbers. For example, "1920x1080" reduces to "16:9".
// Return a string in format "W:H", for example, "16:9".


function getWiderAspectRatio(firstRes, secondRes) {
    
    const [w1,h1] = firstRes.split("x");
    const [w2,h2] = secondRes.split("x");

    // Below was too verbose and complex
    // const isFirstLarger = (w1*h2 > w2*h1);

    // if(isFirstLarger){
    //     const gcd = getGcd(w1,h1);
    //     return `${w1/gcd}:${h1/gcd}`;
    // }
    // else{
    //     const gcd = getGcd(w2,h2);
    //     return `${w2/gcd}:${h2/gcd}`;
    // }

    // Simpler and better
    /// Using Cross multiply to identify which is larger
    const [w,h] = (w1*h2 > w2*h1) ? [w1,h1] : [w2,h2];
    const gcd = getGcd(w,h);

    return `${w/gcd}:${h/gcd}`;

}

function getGcd(a, b) {
    // console.log(`Checking ${a}x${b}`);
    while (b !== 0) {
        [a, b] = [b, a % b];
    }
    // console.log(`GDC is ${a}`);
    return a;
}

console.log(
    "result:", getWiderAspectRatio("1920x1080", "800x600"),
    "result:", getWiderAspectRatio("1080x1350", "2048x1536"),
    "result:", getWiderAspectRatio("640x480", "2440x1220"),
    "result:", getWiderAspectRatio("360x640", "1080x1920"),
    "result:", getWiderAspectRatio("3440x1440", "2048x858"),
    "result:", getWiderAspectRatio("12345x61234", "12534x51234")
);
