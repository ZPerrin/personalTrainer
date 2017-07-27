$(function() {

    // draw login-graphic
    var loginPoly = drawLoginGraphic();
});


function drawLoginGraphic() {

    var loginGraphic = d3.select('.login-graphic'),
        cx = loginGraphic.style('width').replace(/\D/g, '')/2,
        cy = loginGraphic.style('height').replace(/\D/g, '')/2,
        r = cx, // radius
        s = 5, // number of sides of the polygon
        theta = 2*Math.PI / s, // angle between sides
        alpha = s%2 == 1 ? Math.PI/2 : Math.PI/2 - theta/2; // starting angle of 90 degrees for an odd sided poly, 90+ half of theta for even

    var polygon = loginGraphic.append('polygon')
        .attr('class', 'login-poly')
        .attr('points', computePolyPoints(cx,cy,r,s,alpha,theta));

    return polygon;
}

function computePolyPoints(cy, cx, r, s, alpha, theta) {
    var polyPoints = '';
    for (var i = 0; i < s; i++) {
        var tau = alpha + (i * theta),
            vx = Math.round(cx + r * Math.cos(tau)),
            vy = Math.round(cy - r * Math.sin(tau));

        polyPoints += vx + "," + vy + " ";
    }
    return polyPoints;
}