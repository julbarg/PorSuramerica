function initialize() {
	loadMapOrigin();
	// loadMapDestination();
}

function loadMapOrigin() {

	var origin;
	var destination;
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

	// Create the search box and link it to the UI element.
	var input = /** @type {HTMLInputElement} */
	(document.getElementById('pac-input-origin'));
	map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

	var searchBox = new google.maps.places.SearchBox(
	/** @type {HTMLInputElement} */
	(input));

	// [START region_getplaces]
	// Listen for the event fired when the user selects an item from the
	// pick list. Retrieve the matching places for that item.
	directionsDisplay.setMap(map);
	google.maps.event.addListener(directionsDisplay, 'directions_changed',
			function() {
				computeTotalDistance(directionsDisplay.getDirections());
			});

	google.maps.event.addListener(searchBox, 'places_changed', function() {
		var places = searchBox.getPlaces();

		if (places.length == 0) {
			return;
		}
		for (var i = 0, marker; marker = markers[i]; i++) {
			marker.setMap(null);
		}

		// For each place, get the icon, place name, and location.
		markers = [];
		var bounds = new google.maps.LatLngBounds();
		for (var i = 0, place; place = places[i]; i++) {
			var image = {
				url : place.icon,
				size : new google.maps.Size(71, 71),
				origin : new google.maps.Point(0, 0),
				anchor : new google.maps.Point(17, 34),
				scaledSize : new google.maps.Size(25, 25)
			};

			// Create a marker for each place.
			var marker = new google.maps.Marker({
				map : map,
				icon : image,
				title : place.name,
				position : place.geometry.location,
				animation : google.maps.Animation.DROP,
				zoom : 8
			});

			origin = new google.maps.LatLng(marker.position.lat(),
					marker.position.lng());

			/*
			 * document.getElementById("title").value = marker.title;
			 * document.getElementById("lat").value = marker.position.lat();
			 * document.getElementById("long").value = marker.position.lng();
			 */

			markers.push(marker);

			bounds.extend(place.geometry.location);
		}

		map.fitBounds(bounds);
	});
	// [END region_getplaces]

	// Create the search box and link it to the UI element.
	var input2 = /** @type {HTMLInputElement} */
	(document.getElementById('pac-input-destination'));
	map.controls[google.maps.ControlPosition.TOP_LEFT].push(input2);

	var searchBox2 = new google.maps.places.SearchBox(
	/** @type {HTMLInputElement} */
	(input2));

	// [START region_getplaces]
	// Listen for the event fired when the user selects an item from the
	// pick list. Retrieve the matching places for that item.
	google.maps.event.addListener(searchBox2, 'places_changed',
			function() {
				var places = searchBox2.getPlaces();

				if (places.length == 0) {
					return;
				}

				// For each place, get the icon, place name, and location.
				markers = [];
				var bounds = new google.maps.LatLngBounds();
				for (var i = 0, place; place = places[i]; i++) {
					var image = {
						url : place.icon,
						size : new google.maps.Size(71, 71),
						origin : new google.maps.Point(0, 0),
						anchor : new google.maps.Point(17, 34),
						scaledSize : new google.maps.Size(25, 25)
					};

					// Create a marker for each place.
					var marker = new google.maps.Marker({
						map : map,
						icon : image,
						title : place.name,
						position : place.geometry.location,
						animation : google.maps.Animation.DROP,
						zoom : 8
					});

					destination = new google.maps.LatLng(marker.position.lat(),
							marker.position.lng());

					calcRoute(origin, destination, directionsService,
							directionsDisplay);

					/*
					 * document.getElementById("title").value = marker.title;
					 * document.getElementById("lat").value =
					 * marker.position.lat();
					 * document.getElementById("long").value =
					 * marker.position.lng();
					 */

					markers.push(marker);

					bounds.extend(place.geometry.location);
				}

				map.fitBounds(bounds);
			});
	// [END region_getplaces]

	// Bias the SearchBox results towards places that are within the bounds of
	// the
	// current map's viewport.
	google.maps.event.addListener(map, 'bounds_changed', function() {
		var bounds = map.getBounds();
		searchBox.setBounds(bounds);
		searchBox2.setBounds(bounds);
	});
}

function computeTotalDistance(result) {
	var total = 0;
	var myroute = result.routes[0];
	for (var i = 0; i < myroute.legs.length; i++) {
		total += myroute.legs[i].distance.value;
	}
	total = total / 1000.0;
	total = Math.round(total * 100) / 100;
	document.getElementById('km').value = total + ' km';
}

function calcRoute(origin, destination, directionsService, directionsDisplay) {
	var request = {
		origin : origin,
		destination : destination,
		travelMode : google.maps.TravelMode.DRIVING
	};
	directionsService.route(request, function(response, status) {
		if (status == google.maps.DirectionsStatus.OK) {
			directionsDisplay.setDirections(response);
		}
	});
}
