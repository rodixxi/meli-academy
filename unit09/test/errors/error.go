package errors

type MiError struct {
	mensaje string
}

func New(m string) error {
	return &MiError{m}
}

func (e *MiError) Error() string {
	return e.mensaje
}
