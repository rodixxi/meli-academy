package agencies

class AgenciesController {

    def agenciesService

    def index() { }

    def search() {
        def near_to = "${params.lat},${params.lon}"
        [agencies: agenciesService.call(near_to, params.limit, params.offset)]
    }
}
