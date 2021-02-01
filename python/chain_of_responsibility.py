class Factory:

    @staticmethod
    def create_pipeline(config):
        return Pipeline()


class Pipeline:
    def __init__(self, *args, **kwargs) -> None:
        self.head = Context(Handler())
        self.tail = Context(Handler())
        self.head.next_ = self.tail
        self.tail.prev = self.head

    def pre_process(self, data):
        pass

    def step_one_process(self):
        Context.invoke_step_one(self.head, self.request)

    def filter_process(self):
        pass

    def step_two_process(self):
        Context.invoke_step_two(self.head, self.request)

    def post_process(self):
        pass

    def add_handler(self, handler):
        pass


class Context:
    def __init__(self, handler) -> None:
        self.prev = None
        self.next_ = None
        self.handler = handler

    @property
    def next(self):
        return self.next_

    @staticmethod
    def invoke_step_one(ctx, request):
        if ctx:
            try:
                ctx.handler.step_one_(ctx, request)
            except Exception as e:
                ctx.handler.exception_(ctx, request, e)

    def step_one(self, request):
        self.invoke_step_one(self.next, request)

    @staticmethod
    def invoke_step_two(ctx, request):
        if ctx:
            try:
                ctx.handler.step_two_(ctx, request)
            except Exception as e:
                ctx.handler.exception_(ctx, request, e)

    def step_two(self, request):
        self.invoke_step_two(self.next, request)


class Handler:
    def __init__(self, *args, **kwargs) -> None:
        pass

    @property
    def name(self):
        return self.__class__.__name__

    def step_one_(self, ctx, request):
        self.step_one(request)
        ctx.step_one(request)

    def step_one(self, request):
        pass

    def step_two_(self, ctx, request):
        self.step_two(request)
        ctx.step_two(request)

    def step_two(self, request):
        pass

    def exception_(self, ctx, request, a):
        self.exception(request, a)
        pass

    def exception(self, request, a):
        pass


class Request:
    def __init__(self, *args) -> None:
        pass
