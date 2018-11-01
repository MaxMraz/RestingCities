const abbr = window.location.pathname.split('/')[2]
fetch(`/api/states/${abbr}`)
	.then(res => res.json())
	.then(data => {
		const body = document.body
		const pageTitle = `<h1>${data.name}</h1>`
		const pageMotto = `<h2>${data.motto}</h2>`
		const pageFish = `<h2>${data.fish.fishName}</h2>`	

		body.innerHTML += pageTitle
		body.innerHTML += pageMotto
		body.innerHTML += pageFish
		
		const pageCitiesTitle = `<h1>Cities</h1>`
			
		body.innerHTML += pageCitiesTitle
		
		
	
	})
	
	fetch(`/api/states/${window.location.pathname.split('/')[2]}/cities`)
	.then(res => res.json())
	.then(cities => {
		console.log(cities)
		// const citiesList = `<p>${data}</p>`
		const body = document.body
		const list = document.createElement('ul')
		cities.forEach(city => {
			let item = document.createElement('li')
			let item2 = document.createElement('li')
			item.innerHTML = `<p>${city.name}</p>`
			item2.innerHTML = `<p>Population: ${city.population}</p>`
			list.appendChild(item)
			list.appendChild(item2)
		})
		body.appendChild(list)
	})