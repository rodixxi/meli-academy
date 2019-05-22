import React from 'react'

const API_MELI_SITES = "https://api.mercadolibre.com/sites";

class Site extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      sites: [],
      isLoading: false,
      error: null,
    };
  }

  componentDidMount() {
    this.setState({isLoading: true});
    fetch(API_MELI_SITES)
        .then(response => {
          if (!response.ok) {
            throw new Error("Something went wrong...")
          }
          return response.json()
        })
        .then(data => this.setState({categories: data, isLoading: false}))
        .catch(error => this.setState({error, isLoading: false}));
  }

  render() {
    const { sites, isLoading, error } = this.state;
    
    if (error) {
      return (
          <div>
            <p>{error.message}</p>
          </div>
      )
    }
    
    if (isLoading) {
      return (
          <div>
            <p>Loading...</p>
          </div>
      )
    }

    return (
        <div className="row">
            {sites.map(site =>
                <div className="card col-3" id={site.id}>
                        <div className="card-body">
                            <h5 className="card-title">{site.name}</h5>
                        </div>
                </div>
            )}
        </div>
    )
  }
}
export default Site;