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

   var input = /** @type {HTMLInputElement} */
   (document.getElementById('pac-input-origin'));
   map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

   var bounds = new google.maps.LatLngBounds();

   // [START City Origin]
   var searchBox = new google.maps.places.SearchBox(
   /** @type {HTMLInputElement} */
   (input));

   directionsDisplay.setMap(map);
   google.maps.event.addListener(directionsDisplay, 'directions_changed', function() {
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

      markers = [];
      for (var i = 0, place; place = places[i]; i++) {
         var image = {
            url : place.icon,
            size : new google.maps.Size(71, 71),
            origin : new google.maps.Point(0, 0),
            anchor : new google.maps.Point(17, 34),
            scaledSize : new google.maps.Size(25, 25)
         };

         var marker = new google.maps.Marker({
            map : map,
            icon : image,
            title : place.name,
            position : place.geometry.location,
            animation : google.maps.Animation.DROP,
            zoom : 8
         });

         origin = new google.maps.LatLng(marker.position.lat(), marker.position.lng());

         document.getElementById("form:cityOrigin").value = marker.title;
         document.getElementById("form:cityOriginLat").value = marker.position.lat();
         document.getElementById("form:cityOriginLng").value = marker.position.lng();

         document.getElementById("form:city").value = marker.title;
         document.getElementById("form:cityLat").value = marker.position.lat();
         document.getElementById("form:cityLng").value = marker.position.lng();

         markers.push(marker);

         bounds.extend(place.geometry.location);
      }

      map.fitBounds(bounds);
   });
   // [END City Origin]

   var input3 = /** @type {HTMLInputElement} */
   (document.getElementById('pac-input-way'));
   map.controls[google.maps.ControlPosition.TOP_LEFT].push(input3);

   // [START City WayPoint 1]
   var searchBox3 = new google.maps.places.SearchBox(
   /** @type {HTMLInputElement} */
   (input3));

   directionsDisplay.setMap(map);
   google.maps.event.addListener(directionsDisplay, 'directions_changed', function() {
      computeTotalDistance(directionsDisplay.getDirections());
   });

   google.maps.event.addListener(searchBox3, 'places_changed', function() {
      var places = searchBox3.getPlaces();

      if (places.length == 0) {
         return;
      }
      for (var i = 0, marker; marker = markers[i]; i++) {
         marker.setMap(null);
      }

      markers = [];
      for (var i = 0, place; place = places[i]; i++) {
         var image = {
            url : place.icon,
            size : new google.maps.Size(71, 71),
            origin : new google.maps.Point(0, 0),
            anchor : new google.maps.Point(17, 34),
            scaledSize : new google.maps.Size(25, 25)
         };

         var marker = new google.maps.Marker({
            map : map,
            icon : image,
            title : place.name,
            position : place.geometry.location,
            animation : google.maps.Animation.DROP,
            zoom : 8
         });

         waypts.push({
            location: place.geometry.location
        });

         markers.push(marker);

         bounds.extend(place.geometry.location);
      }

      map.fitBounds(bounds);
   });
   // [END City Origin]

   // [START City Destination]
   var input2 = /** @type {HTMLInputElement} */
   (document.getElementById('pac-input-destination'));
   map.controls[google.maps.ControlPosition.TOP_LEFT].push(input2);

   var searchBox2 = new google.maps.places.SearchBox(
   /** @type {HTMLInputElement} */
   (input2));

   google.maps.event.addListener(searchBox2, 'places_changed', function() {
      var places = searchBox2.getPlaces();

      if (places.length == 0) {
         return;
      }

      for (var i = 0, marker; marker = markers[i]; i++) {
         marker.setMap(null);
      }

      markers = [];
      for (var i = 0, place; place = places[i]; i++) {
         var image = {
            url : place.icon,
            size : new google.maps.Size(71, 71),
            origin : new google.maps.Point(0, 0),
            anchor : new google.maps.Point(17, 34),
            scaledSize : new google.maps.Size(25, 25)
         };

         var marker = new google.maps.Marker({
            map : map,
            icon : image,
            title : place.name,
            position : place.geometry.location,
            animation : google.maps.Animation.DROP,
            zoom : 8
         });

         destination = new google.maps.LatLng(marker.position.lat(), marker.position.lng());

         calcRoute(origin, destination, directionsService, directionsDisplay);

         document.getElementById("form:cityDestination").value = marker.title;
         document.getElementById("form:cityDestinationLat").value = marker.position.lat();
         document.getElementById("form:cityDestinationLng").value = marker.position.lng();

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
      searchBox3.setBounds(bounds);
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
   document.getElementById('form:km').value = total + ' km';
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
      } else {
         alert("No se encontro ruta entre las dos ciudades");
      }
   });
}
