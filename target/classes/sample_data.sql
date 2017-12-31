use locationdb


db.markers.insert(
   [
     {name:"Hotel Ellora park", address:"Dhankawadi", lat:"18.465853", lng:"73.858193"}, 
	{name:"Hotel Krushna", address:"Dhankawadi", lat:"18.4681503", lng:"73.8538022"}, 
	{name:"Vivanta by Taj", address:"Koregaon Park", lat:"18.540112", lng:"73.8882739"}, 
	{name:"The Westin", address:"Koregaon Park", lat:"18.540112", lng:"73.8882739"}, 
	{name:"Hotel ABC Inn", address:" Nigdi", lat:"18.657125", lng:"73.7716086"}, 
	{name:"Hotel Krishna Regency", address:"Nigdi", lat:"18.657125", lng:"73.7716086"}, 
	{name:"Hotel Basera", address:"Bajirao Road", lat:"18.5193718", lng:"73.8519211"}, 
	{name:"Hotel Sapna", address:"Shivajinagar", lat:"18.5193718", lng:"73.8519211"}

   ]
)


db.markers.insert(
   [
     { name:"Hotel Ellora park", address:"Dhankawadi", location:[18.465853, 73.858193]},
	{ name:"Hotel Krushna", address:"Dhankawadi", location:[18.4681503, 73.8538022]},
	{ name:"Vivanta by Taj", address:"Koregaon Park", location:[18.5381664, 73.8836541]},
	{ name:"The Westin", address:"Koregaon Park", location:[18.540112, 73.8882739]},
	{ name:"Hotel ABC Inn", address:" Nigdi", location:[18.657125, 73.7716086]},
	{ name:"Hotel Krishna Regency", address:"Nigdi", location:[18.6609543, 73.7730757]},
	{ name:"Hotel Basera", address:"Bajirao Road", location:[18.5193718, 73.8519211]},
	{ name:"Hotel Sapna", address:"Shivajinagar", location:[18.519446, 73.8437213]}

   ]
)