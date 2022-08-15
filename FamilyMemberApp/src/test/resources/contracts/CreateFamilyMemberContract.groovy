package contracts

org.springframework.cloud.contract.spec.Contract.make {
	request {
		method 'POST'
		url '/createFamilyMember'
		body(
		familyMember: {
			givenName:anyNonBlankString(),age:anyNumber()
		}
		)
		headers {
			contentType(applicationJson())
		}
	}
	response {
		status 200
		body(
		familyMember: {
			id:anyNumber(),familyid:anyNumber(),familyName:anyNonBlankString(),givenName:anyNonBlankString(),age:anyNumber()
		}
		)
		headers {
			contentType(applicationJson())
		}
	}
}