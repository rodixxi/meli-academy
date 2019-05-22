import React from 'react'

const API_MELI_SITES = "https://api.mercadolibre.com/sites";

class Category extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      categories: [],
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
    const { categories, isLoading, error } = this.state;
    
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
            {categories.map(category =>
                <div className="card col-3" id={category.id}>
                    <img className="card-img-top" src={category.picture} alt={category.name}/>
                    <div className="card-body">
                            <h5 className="card-title">{category.name}</h5>
                        </div>
                </div>
            )}
        </div>
    )
  }
}

export default Category;