$(function () {

    // draw the login graphic
    var loginSVG = drawLoginGraphic(5);
});


// TODO: export this into some sort of re-usable component
/**
 * Draws the login graphic
 *
 * @param s - number of sides for the polygon graphic
 * @returns - d3 selection of the login svg element
 */
function drawLoginGraphic(s) {

    var loginGraphic = d3.select('.login-graphic'),
        cx = loginGraphic.style('width').replace(/\D/g, '') / 2,
        cy = loginGraphic.style('height').replace(/\D/g, '') / 2,
        r = cx, // radius
        theta = 2 * Math.PI / s, // angle between sides
        alpha = s % 2 == 1 ? Math.PI / 2 : Math.PI / 2 - theta / 2, // starting angle of 90 degrees for an odd sided poly, 90+ half of theta for even
        polyPoints = computePolyPoints(cx, cy, r, s, alpha, theta),
        tickPoints = computeTickPoints(cx, cy, r, s, alpha, theta);

    var polygon = loginGraphic.append('polygon')
        .attr('class', 'login-poly')
        .attr('points', composePolyAttribute(polyPoints));

    loginGraphic.selectAll('line').data(polyPoints)
        .enter()
        .append('line')
        .attr('class', 'login-line')
        .attr('x1', cx)
        .attr('y1', cy)
        .attr('x2', function (point) {
            return point.x
        })
        .attr('y2', function (point) {
            return point.y
        });

    loginGraphic.selectAll('.login-tick').data(tickPoints)
        .enter()
        .append('line')
        .attr('class', 'login-line')
        .attr('x1', function (points) {
            return points.vx1
        })
        .attr('y1', function (points) {
            return points.vy1
        })
        .attr('x2', function (points) {
            return points.vx2
        })
        .attr('y2', function (points) {
            return points.vy2
        });

    return loginGraphic;
}

// defines the polygon
function computePolyPoints(cy, cx, r, s, alpha, theta) {
    var pointArray = [];
    for (var i = 0; i < s; i++) {
        var tau = alpha + (i * theta),
            vx = Math.round(cx + r * Math.cos(tau)),
            vy = Math.round(cy - r * Math.sin(tau));

        pointArray.push({x: vx, y: vy});
    }
    return pointArray;
}

// defines the ticks within the polygon - currently every 25% towards a vertice
function computeTickPoints(cy, cx, r, s, alpha, theta) {
    var pointArray = [];
    for (var i = 0; i < s; i++) {
        var tau = alpha + (i * theta),
            delta = tau + theta;

        for (var j = 1; j <= 3; j++) {
            var vx1 = Math.round(cx + (r * (.25 * j)) * Math.cos(tau)),
                vy1 = Math.round(cy - (r * (.25 * j)) * Math.sin(tau)),
                vx2 = Math.round(cx + (r * (.25 * j)) * Math.cos(delta)),
                vy2 = Math.round(cy - (r * (.25 * j)) * Math.sin(delta));

            pointArray.push({vx1: vx1, vy1: vy1, vx2: vx2, vy2: vy2});
        }
    }
    return pointArray;
}

// converts an array of points to a svg polygon 'points' attribute
function composePolyAttribute(pointArray) {
    var attributeString = '';
    pointArray.forEach(function (point) {
        attributeString += +point.x + ',' + point.y + ' ';
    });
    return attributeString.trim();
}
