package contracts
 
org.springframework.cloud.contract.spec.Contract.make {
    request {
		method 'get'
		url '/searchFamilyMember/{id}'
		body( id: anyNumber()	)
		headers {
			contentType(applicationJson())
		}
	}
	response {
		status 200
		body(
		searchFamilyMember: {[]}
		)
		headers {
			contentType(applicationJson())
		}
	}
}