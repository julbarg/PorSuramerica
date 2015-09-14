var waypts = [];
function initialize() {
	loadMapOrigin();
}

function loadMapOrigin() {

	var markers = [];
	var mapCanvas = document.getElementById('map-canvas-origin');
	var mapOptions = {
		scrollwheel : false,
		center : new google.maps.LatLng(-21.7351043, -63.2812499),
		zoom : 3,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	}

	var map = new google.maps.Map(mapCanvas, mapOptions);
	var rendererOptions = {
		draggable : true
	};
	var directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);
	var directionsService = new google.maps.DirectionsService();

	directionsDisplay.setMap(map);

	origin = new google.maps.LatLng(4.478235, -75.2436045);
	destination = new google.maps.LatLng(-34.6158238, -58.4332985);
	var way = new google.maps.LatLng(3.3950644,-76.525664);

	waypts.push({
		location : way
	});
	
	way = new google.maps.LatLng(1.2135255,-77.2772226);
	
	waypts.push({
		location : way
	});

	calcRoute(origin, destination, directionsService, directionsDisplay);
}

function computeTotalDistance(result) {
	var total = 0;
	var myroute = result.routes[0];
	for (var i = 0; i < myroute.legs.length; i++) {
		total += myroute.legs[i].distance.value;
	}
	total = total / 1000.0;
	total = Math.round(total * 100) / 100;
	document.getElementById('form_route:km').value = total + ' km';
}

function calcRoute(origin, destination, directionsService, directionsDisplay) {
	var request = {
		origin : origin,
		destination : destination,
		waypoints : waypts,
		travelMode : google.maps.TravelMode.DRIVING
	};
	directionsService.route(request, function(response, status) {
		if (status == google.maps.DirectionsStatus.OK) {
			directionsDisplay.setDirections(response);
			computeTotalDistance(directionsDisplay.getDirections());
		} else {
			alert("No se encontro ruta entre las dos ciudades");
		}
	});
}
