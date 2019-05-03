package agencies

class AgenciesController {

    def agenciesService
    def agencyService
    def agenciesArr

    def index() { }

    def search() {
        def near_to = "${params.lat},${params.lon}"
        agenciesArr = agenciesService.call(near_to, params.limit, params.offset)
        [agencies: agenciesArr]
    }

    def like() {
        getAgency(params.id).save()
    }

    def dislike() {
        agencyService.delete(params.id)
    }

    Agency getAgency(String id) {
        def favAgency = agenciesArr.find{
            it.id == id
            }
        return (Agency) favAgency
    }
}
