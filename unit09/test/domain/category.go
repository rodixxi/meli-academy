package domain

type Category struct {
	Id string
	Name string
	Site Site
}

func (c Category) GetSite() Site {
	return c.Site
}

func (c Category) GetIdsConcat() string {
	return c.Id + " - " + c.Site.Id
}

func (c Category) getSomething(t string) string  {
	return c.Name + "--" + t
}

func (c Category) ChangeName(name string)  {
	c.Name = name
}

func (c *Category) ChangeNameP(name string)  {
	c.Name = name
}